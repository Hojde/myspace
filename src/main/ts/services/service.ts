import { IHeader } from "../models/Header";

const API_URL = "http://localhost:8080/myspace/api";

type HttpMethod = "GET" | "POST" | "PUT" | "DELETE";

const apiFetch = async <TResponse, TBody = unknown>(
  endpoint: string,
  method: HttpMethod,
  data?: TBody,
  additionalHeaders?: IHeader[],
): Promise<TResponse> => {
  const url = API_URL + endpoint;

  const headers = new Headers();
  headers.set("Accept", "application/json");
  headers.set("Content-Type", "application/json");

  additionalHeaders?.forEach(({ name, value }) => headers.append(name, value));

  const fetchInit: RequestInit = {
    method,
    headers,
    body: data ? JSON.stringify(data) : undefined,
  };

  const resp = await fetch(url, fetchInit);

  if (!resp.ok) {
    console.error(`Error when fetching ${method} ${url}`, data);
    throw new Error(resp.statusText);
  }

  return (await resp.json()) as TResponse;
};

// Helpers typés
export const apiGet = <T>(endpoint: string, additionalHeaders?: IHeader[]) =>
  apiFetch<T>(endpoint, "GET", undefined, additionalHeaders);

export const apiPost = <TResponse, TBody>(
  endpoint: string,
  data: TBody,
  additionalHeaders?: IHeader[],
) => apiFetch<TResponse, TBody>(endpoint, "POST", data, additionalHeaders);

export const apiDelete = <T>(
  endpoint: string,
  id: string,
  additionalHeaders?: IHeader[],
) => apiFetch<T>(`${endpoint}${id}`, "DELETE", undefined, additionalHeaders);
