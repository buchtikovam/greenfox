import React from "react";

export default function VehiclesFilter({
  setFilter,
  vehicleMap,
  setQueryParams,
}) {
  function handleClick(type) {
    setFilter(type);
    setQueryParams(`?${new URLSearchParams({ type })}`);
  }

  return (
    <div className="filter-buttons">
      {Object.entries(vehicleMap).map((vehicleTypeArray) => (
        <button
          key={vehicleTypeArray[0]}
          type="button"
          className="filter-button"
          onClick={() => handleClick(vehicleTypeArray[1])}
        >
          {vehicleTypeArray[1].toLowerCase().charAt(0).toUpperCase() +
            vehicleTypeArray[1].slice(1).toLowerCase()}
        </button>
      ))}
    </div>
  );
}
