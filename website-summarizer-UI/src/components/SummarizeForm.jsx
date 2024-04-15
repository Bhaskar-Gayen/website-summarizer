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
        setSummary(response.data);
      })
      .catch((err) => {
        console.log(err);
        setError("Failed to summarize URL");
      });
  };

  return (
    <>
      <form class="space-y-6" onSubmit={handleSummarize}>
        <label class="block text-sm font-medium text-gray-700">
          Website URL:
        </label>
        <input
          id="url"
          name="url"
          type="text"
          autoComplete="url"
          required
          class="block w-full px-3 py-2 mt-1 text-gray-900 placeholder-gray-500 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
          value={url}
          onChange={handleInputChange}
        />
        <div class="flex justify-between items-center">
          <button
            type="submit"
            disabled={loading}
            class="inline-block px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-blue-600 border border-transparent rounded-md shadow-sm disabled:opacity-50 hover:bg-blue-700 focus:outline-none focus:ring-blue-500 focus:border-blue-500 active:bg-blue-700"
          >
            {loading ? "Loading..." : "Summarize"}
          </button>
        </div>
      </form>
      {summary && <div>{summary}</div>}
      {error && <div>{error}</div>}
    </>
  );
};

export default SummarizeForm;
