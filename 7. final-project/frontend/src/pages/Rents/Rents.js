import React, { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { useRent } from "../../hooks/useRent";
import VehicleList from "../../components/VehicleList/VehicleList";
import RentsFilter from "../../components/RentsFilter/RentsFilter";

const RentStatusMap = {
  0: "RENTED",
  1: "IN_USE",
  2: "AVAILABLE",
};

function RentAction({ vehicleProp: rent, updateStatus }) {
  const isRented = rent.rent_status === RentStatusMap[0];
  const isInUse = rent.rent_status === RentStatusMap[1];
  const isAvailable = rent.rent_status === RentStatusMap[2];

  if (isRented) {
    return (
      <button
        type="button"
        className="rent-btn"
        onClick={() => updateStatus(rent.rent_id, RentStatusMap[1])}
      >
        Use
      </button>
    );
  }

  if (isInUse) {
    return (
      <button
        type="button"
        className="rent-btn"
        onClick={() => updateStatus(rent.rent_id, RentStatusMap[2])}
      >
        Stop using
      </button>
    );
  }

  if (isAvailable) {
    return null;
  }
}

export default function Rents() {
  const { fetchByStatus, flattenedRents, refresh, updateSingleStatus } =
    useRent();

  const [queryParams, setQueryParams] = useSearchParams();
  const [choosenFilter, setChoosenFilter] = useState(queryParams.get("status"));

  const filteredRents = flattenedRents.filter((rent) =>
    choosenFilter.split(",").includes(rent.rent_status),
  );

  useEffect(() => {
    fetchByStatus(["RENTED, IN_USE, AVAILABLE"]);
  }, [fetchByStatus, refresh]);

  return (
    <VehicleList
      vehiclesProp={filteredRents}
      actionElement={<RentAction updateStatus={updateSingleStatus} />}
    >
      <RentsFilter
        setFilter={setChoosenFilter}
        rentMap={RentStatusMap}
        setQueryParams={setQueryParams}
      />
    </VehicleList>
  );
}
