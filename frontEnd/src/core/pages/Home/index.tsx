import Catalog from "../Catalog";
import "./styles.scss";

const Home = () => (
  <div className="home-container">
    <div className="row home-content card-base border-radius-20">
      <Catalog />
    </div>
  </div>
);

export default Home;
