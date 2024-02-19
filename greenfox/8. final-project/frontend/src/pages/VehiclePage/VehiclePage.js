import React, { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import VehicleList from "../../components/VehicleList/VehicleList";
import VehiclesFilter from "../../components/VehiclesFilter/VehiclesFilter";
import { useRent } from "../../hooks/useRent";
import "./VehiclePage.css";

function RentAction({ vehicleProp: vehicle, rentedVehicles, rentVehicle }) {
  const isPending = rentedVehicles.some(
    (rentedVehicle) => rentedVehicle.id === vehicle.id,
  );

  return (
    <button
      type="button"
      disabled={isPending}
      className="rent-btn"
      onClick={() => rentVehicle(vehicle.id)}
    >
      {isPending ? "Pending" : "Rent"}
    </button>
  );
}

const vehicleTypeMap = {
  0: "All",
  1: "BIKE",
  2: "SCOOTER",
  3: "MOTORBIKE",
  4: "CAR",
};

export default function VehiclePage() {
  const {
    vehicles,
    fetchVehicles,
    fetchByStatus,
    refresh,
    rentedVehicles,
    rentVehicle,
  } = useRent();

  const [queryParams, setQueryParams] = useSearchParams();
  const [choosenFilter, setChoosenFilter] = useState(queryParams.get("type"));

  const filteredVehicles =
    choosenFilter === "All"
      ? vehicles
      : vehicles.filter((vehicle) => choosenFilter === vehicle.type);

  useEffect(() => {
    fetchVehicles().then(() => fetchByStatus("PENDING"));
  }, [refresh]);

  return (
    <div>
      <VehicleList
        vehiclesProp={filteredVehicles}
        actionElement={
          <RentAction
            rentedVehicles={rentedVehicles}
            rentVehicle={rentVehicle}
          />
        }
      >
        <VehiclesFilter
          setFilter={setChoosenFilter}
          vehicleMap={vehicleTypeMap}
          setQueryParams={setQueryParams}
        />
      </VehicleList>
    </div>
  );
}
