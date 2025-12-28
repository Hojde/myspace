import { useEffect } from "react";
import { Table, Tag } from "antd";
import { ITabFile } from "../../models/Tab";
import { ColumnsType } from "antd/es/table";
import { TABS_FILE_TYPES } from "./constants";

interface ITabFilesListProps {
  files: ITabFile[];
}

export const TabFilesList = (props: ITabFilesListProps) => {
  const { files } = props;

  const columns: ColumnsType<ITabFile> = [
    {
      key: "instruments",
      dataIndex: "instruments",
      render: (_, { instruments }) => (
        <>
          {instruments &&
            instruments.map((instrument, index) => (
              <Tag
                id={instrument + index}
                color={"geekblue"}
                key={instrument + index}
              >
                {instrument}
              </Tag>
            ))}
        </>
      ),
    },
    {
      key: "type",
      dataIndex: "fileType",
      render: (_, { fileType, fileUrl }) => ({
        props: { style: { display: "flex", alignItems: "center" } },
        children: (
          <a
            href={fileUrl}
            target="new"
            title={`Download in ${fileType} format`}
          >
            <img
              src={
                fileType &&
                TABS_FILE_TYPES.find((t) => t.id === fileType)?.iconUrl
              }
              alt={
                fileType && TABS_FILE_TYPES.find((t) => t.id === fileType)?.name
              }
              style={{ width: "30px" }}
            />
          </a>
        ),
      }),
    },
  ];

  useEffect(() => {
    files.map((file, index) => {
      file.key = "file-" + file.fileUrl + "-" + index;
    });
  }, []);

  return (
    <Table
      showHeader={false}
      pagination={false}
      columns={columns}
      dataSource={files}
    />
  );
};
