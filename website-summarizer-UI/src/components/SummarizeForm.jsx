import React, { useState } from "react";
import axios from "axios";

const SummarizeForm = () => {
  const [url, setUrl] = useState("");
  const [loading, setLoading] = useState(false);
  const [summary, setSummary] = useState("");
  const [error, setError] = useState(null);

  const handleInputChange = (event) => {
    setUrl(event.target.value);
  };

  const handleSummarize = async (event) => {
    console.log("hicewopn  buo");
    event.preventDefault();
    setLoading(true);

    axios
      .post(
        `http://localhost:8080/api/summarize`,
        { weblink: url },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        console.log(response.data);
        response = JSON.parse(response.data);
        setSummary(response);
      })
      .catch((err) => {
        console.log(err);
        setError("Failed to summarize URL");
      });
  };

  return (
    <>
      <div className="max-w-screen-md mx-aut p-4">
        <form className="space-y-6" onSubmit={handleSummarize}>
          <label className="block text-sm font-medium text-gray-700">
            Website URL:
          </label>
          <input
            id="url"
            name="url"
            type="text"
            autoComplete="url"
            required
            className="block w-full px-3 py-2 mt-1 text-gray-900 placeholder-gray-500 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
            value={url}
            onChange={handleInputChange}
          />
          <div className="flex justify-between items-center">
            <button
              type="submit"
              disabled={loading}
              className="inline-block px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-blue-600 border border-transparent rounded-md shadow-sm disabled:opacity-50 hover:bg-blue-700 focus:outline-none focus:ring-blue-500 focus:border-blue-500 active:bg-blue-700"
            >
              {loading ? "Loading..." : "Summarize"}
            </button>
          </div>
        </form>
        {summary && (
          <div className="mt-4 bg-white shadow-md rounded-md overflow-hidden">
            <div className="p-2 md:p-4">
              {summary
                .split("*")
                .filter(Boolean)
                .map((paragraph, index) => (
                  <p key={index} className="text-sm md:text-base">
                    {paragraph.trim()}
                  </p>
                ))}
            </div>
          </div>
        )}
        {error && <div className="text-red-500">{error}</div>}
      </div>
    </>
  );
};

export default SummarizeForm;
