import { Layout, Menu, MenuProps } from "antd";
import { ContainerOutlined, UnorderedListOutlined } from "@ant-design/icons";
import "./Home.css";

function HomePage() {
  const { Header, Content, Footer } = Layout;
  const menuItems: MenuProps["items"] = [
    { key: "feats", label: "Features", icon: <ContainerOutlined /> },
    { key: "todo", label: "Todo", icon: <UnorderedListOutlined /> }
  ];
  return (
    <Layout className="main-layout">
      <Header style={{ backgroundColor: "#FFFFFF", display: "flex" }}>
        <div className="logo">My SPACE</div>
        <Menu
          mode="horizontal"
          defaultSelectedKeys={["feats"]}
          items={menuItems}
          style={{ flex: "auto", justifyContent: "end" }}
        />
      </Header>
      <Content style={{ padding: "0 50px", backgroundColor: "#FFFFFF" }}>
        <div className="site-layout-content">Content</div>
      </Content>
      <Footer style={{ backgroundColor: "#FFFFFF" }} />
    </Layout>
  );
}

export default HomePage;
