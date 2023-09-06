import React from "react";
import ReactDOM from "react-dom/client";
import { ConfigProvider } from "antd";
import HomePage from "./pages/Home";
import "./main.css";

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <ConfigProvider>
    <React.StrictMode>
      <HomePage />
    </React.StrictMode>
  </ConfigProvider>
);
