import { useEffect, useState } from "react";
import { Table } from "antd";
import { ColumnsType } from "antd/es/table";
import { ITab } from "../../models/Tab";
import { fetchTabs } from "../../services/tab-service";
import { TabFilesList } from "./TabFilesList";
import { LISTENING_PLATFORMS } from "./constants";

interface IOption {
  text: string;
  value: string;
}

const TabsList = () => {
  const [tabs, setTabs] = useState<ITab[]>([]);
  const [tabsProjects, setTabsProjects] = useState<IOption[]>([]);

  const columns: ColumnsType<ITab> = [
    {
      title: "Title",
      dataIndex: "title",
      key: "title",
      sorter: (a: ITab, b: ITab) => a.title.length - b.title.length,
      ellipsis: true,
    },
    {
      title: "Artist",
      dataIndex: "artist",
      key: "artist",
      sorter: (a: ITab, b: ITab) => a.artist.length - b.artist.length,
      ellipsis: true,
    },
    {
      title: "Project",
      dataIndex: "project",
      key: "project",
      filters: tabsProjects,
      onFilter: (value: string | number | boolean, record: ITab) =>
        record.project == value,
      sorter: (a: ITab, b: ITab) => a.project.length - b.project.length,
      ellipsis: true,
    },
    {
      title: "Listen",
      dataIndex: "listeningUrls",
      key: "listeningUrls",
      render: (_, { listeningUrls }) => (
        <>
          {listeningUrls &&
            listeningUrls.map(({ listeningPlatform, url }) => (
              <a href={url} style={{ paddingRight: "20px" }}>
                <img
                  src={
                    listeningPlatform &&
                    LISTENING_PLATFORMS.find((t) => t.id === listeningPlatform)
                      ?.iconUrl
                  }
                  alt={
                    listeningPlatform &&
                    LISTENING_PLATFORMS.find((t) => t.id === listeningPlatform)
                      ?.name
                  }
                  title={
                    listeningPlatform &&
                    LISTENING_PLATFORMS.find((t) => t.id === listeningPlatform)
                      ?.name
                  }
                  style={{ height: "30px" }}
                />
              </a>
            ))}
        </>
      ),
    },
  ];
  useEffect(() => {
    fetchTabs().then((fTabs) => {
      fTabs.map((tab, index) => (tab.key = "tab-" + index));
      setTabs(fTabs);
      setTabsProjects(
        [...new Set(tabs.map((tab) => tab.project))].map((project) => ({
          text: project,
          value: project,
        })),
      );
    });
  }, []);

  return (
    <Table
      columns={columns}
      dataSource={tabs}
      expandable={{
        expandedRowRender: (record: ITab) => (
          <TabFilesList files={record.files} />
        ),
        rowExpandable: (record) => record.files && record.files.length > 0,
      }}
      style={{ padding: "30px 65px" }}
    />
  );
};

export default TabsList;
