import Vehicle from "../Vehicle/Vehicle";
import "./VehicleList.css";

export default function VehicleList({ vehiclesProp, actionElement, children }) {
  return (
    <div className="vehicle-list">
      <div className="filter-buttons">
        {children}
        {vehiclesProp.length === 0 ? (
          <div>EMPTY</div>
        ) : (
          <div className="vehicle-map">
            {vehiclesProp.map((vehicle) => (
              <Vehicle
                key={vehicle.rent_id ?? vehicle.id}
                vehicleProp={vehicle}
                actionElement={actionElement}
              />
            ))}
          </div>
        )}
      </div>
    </div>
  );
}
