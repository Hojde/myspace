import { apiGet, apiPost, apiDelete } from "./service";
import { ILanguage } from "../models/Language";

const fetchLanguages = async () => apiGet("/languages");

const persistLanguage = async (language: ILanguage) =>
  apiPost("/languages", language);

const deleteLanguage = async (languageId: string) =>
  apiDelete("/languages", languageId);

// const fetchLanguageProposals = () => {};

export {
  fetchLanguages,
  persistLanguage,
  deleteLanguage,
  // fetchLanguageProposals
};
