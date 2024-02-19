import {
  createContext,
  useCallback,
  useContext,
  useMemo,
  useState,
} from "react";
import VehicleApiService from "../services/api/VehicleApiService";
import RentApiService from "../services/api/RentApiService";

const RentContext = createContext();

export function RentProvider({ children }) {
  const [vehicles, setVehicles] = useState([]);
  const [rents, setRents] = useState([]);
  const [refresh, setRefresh] = useState(false);

  const fetchVehicles = useCallback(async () => {
    const json = await VehicleApiService.getAvailable().json();
    setVehicles(json.map((vehicle) => ({ ...vehicle, isPending: false })));
  }, []);

  const fetchByStatus = useCallback(async (status) => {
    const json = await RentApiService.getAllByStatus(status).json();
    setRents(json);
  }, []);

  const rentVehicle = async (id) => {
    await RentApiService.create(id);
    setRefresh((prevRefresh) => !prevRefresh);
  };

  const updateStatus = async (ids, status) => {
    await RentApiService.updateStatus(ids, status).json();
  };

  const updateSingleStatus = async (id, status) => {
    await RentApiService.updateSingleStatus(id, status).json(() =>
      setRefresh((prevRefresh) => !prevRefresh),
    );
  };

  const rentedVehicles = rents.map((rent) => rent.vehicle);

  const flattenedRents = rents.map((rent) => ({
    rent_id: rent.id,
    rent_status: rent.status,
    rent_date: rent.date,
    id: rent.vehicle.id,
    name: rent.vehicle.name,
    url: rent.vehicle.url,
    altImg: rent.vehicle.altImg,
    type: rent.vehicle.type,
    description: rent.vehicle.description,
    duration: rent.vehicle.duration,
    price: rent.vehicle.price,
    kilometers: rent.vehicle.kilometers,
  }));

  const value = useMemo(
    () => ({
      vehicles,
      rents,
      rentedVehicles,
      flattenedRents,
      fetchVehicles,
      fetchByStatus,
      refresh,
      rentVehicle,
      updateStatus,
      updateSingleStatus,
    }),
    [
      vehicles,
      rents,
      refresh,
      rentedVehicles,
      flattenedRents,
      fetchVehicles,
      fetchByStatus,
    ],
  );

  return <RentContext.Provider value={value}>{children}</RentContext.Provider>;
}

export const useRent = () => useContext(RentContext);
