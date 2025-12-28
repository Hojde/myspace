export interface ITabFile {
  key?: string;
  fileType: string;
  fileUrl: string;
  instruments: string[];
}

export interface IListeningUrl {
  listeningPlatform: string;
  url: string;
}

export interface ITab {
  id: string;
  key?: string;
  title: string;
  artist: string;
  project: string;
  files: ITabFile[];
  listeningUrls: IListeningUrl[];
}
