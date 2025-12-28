import { apiGet, apiPost } from "./service";
import { ITab } from "../models/Tab";

const fetchTabs: () => Promise<ITab[]> = async () => apiGet("/tabs");

const persistTab: (tab: ITab) => Promise<ITab> = async (tab: ITab) =>
  apiPost("/tabs", tab);

const fetchTabFileTypes: () => Promise<string[]> = async () =>
  apiGet("/tabs/file-types");
export { fetchTabs, persistTab, fetchTabFileTypes };
