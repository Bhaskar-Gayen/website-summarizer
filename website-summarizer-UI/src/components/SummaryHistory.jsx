import React, { useState, useEffect } from "react";
import axios from "axios";

const SummaryHistory = () => {
  const [history, setHistory] = useState([]);
  const [error, setError] = useState(null);

  const clearHistory = () => {
    // Implement clear history logic here
    setHistory([]);
  };

  const renderHistory = () => {
    console.log(history);
    return history;
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/history")
      .then((response) => {
        console.log(response.data);
        setHistory(response.data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []); // Empty dependency array to fetch history only once on component mount

  return (
    <div className="p-4 bg-white border border-gray-200 rounded-lg shadow-md">
      <h2 className="text-lg font-medium text-gray-900">Summary History</h2>
      {error && <p className="text-red-500">{error}</p>}
      {history.length > 0 ? (
        <div className="mt-4">
          {renderHistory()}
          <button
            onClick={clearHistory}
            className="mt-4 px-3 py-1 text-sm font-medium text-white bg-red-600 rounded-md shadow-md hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-offset-2"
          >
            Clear History
          </button>
        </div>
      ) : (
        <p className="mt-4 text-gray-500">No past summaries yet.</p>
      )}
    </div>
  );
};

export default SummaryHistory;
