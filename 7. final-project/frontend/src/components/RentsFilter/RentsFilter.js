import React from "react";

export default function RentsFilter({ setFilter, rentMap, setQueryParams }) {
  function handleClick(status) {
    setFilter(status);
    setQueryParams(`?${new URLSearchParams({ status })}`);
  }

  return (
    <div className="filter-buttons">
      <button
        type="button"
        className="filter-button"
        onClick={() => handleClick(`${rentMap[0]},${rentMap[1]}`)}
      >
        Active
      </button>
      <button
        type="button"
        className="filter-button"
        onClick={() => handleClick(`${rentMap[2]}`)}
      >
        History
      </button>
    </div>
  );
}
