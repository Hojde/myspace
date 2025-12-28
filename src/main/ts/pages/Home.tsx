import { Layout, Menu, MenuProps } from "antd";
import { ContainerOutlined } from "@ant-design/icons";
import TabsList from "../components/tabs/TabsList";

function HomePage() {
  const { Header, Content, Footer } = Layout;
  const menuItems: MenuProps["items"] = [
    {
      key: "tabs",
      label: "Sheets & Tabs",
      icon: <ContainerOutlined />,
      children: [{ label: "Add new tab", key: "addTab" }],
    },
  ];

  return (
    <Layout className="main-layout">
      <Header style={{ backgroundColor: "#FFFFFF", display: "flex" }}>
        <div className="logo">My SPACE</div>
        <Menu
          mode="horizontal"
          defaultSelectedKeys={["tabs"]}
          items={menuItems}
          style={{ flex: "auto", justifyContent: "end" }}
        />
      </Header>
      <Content style={{ padding: "0 50px", backgroundColor: "#FFFFFF" }}>
        <TabsList />
      </Content>
      <Footer style={{ backgroundColor: "#FFFFFF" }} />
    </Layout>
  );
}

export default HomePage;
