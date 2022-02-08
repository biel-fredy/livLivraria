import Catalogo from '../Catalogo';
import './styles.scss';

const Home = () => (
  <div className="home-container">
    <div className="row home-content card-base border-radius-20">
      <Catalogo />
    </div>
  </div>
);

export default Home;
