import React, { useState } from "react";
import SummarizeForm from "./components/SummarizeForm";
import SummaryHistory from "./components/SummaryHistory";

function App() {
  const [showHistory, setShowHistory] = useState(false);

  const handleHistory = () => {
    setShowHistory(true);
  };

  return (
    <div className="App">
      <div className="flex justify-center items-center h-screen">
        <div className="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow sm:p-6 md:p-8 dark:bg-gray-800 dark:border-gray-700">
          <h2 className="text-xl font-medium text-gray-900 dark:text-white">
            Summarize a Website
          </h2>
          <SummarizeForm />
          <button
            onClick={handleHistory}
            className="mt-4 text-sm font-medium text-gray-700 underline"
          >
            View History
          </button>
          {showHistory && <SummaryHistory />}
        </div>
      </div>
    </div>
  );
}

export default App;
