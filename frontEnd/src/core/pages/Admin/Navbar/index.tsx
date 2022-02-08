import { NavLink } from 'react-router-dom';
import './styles.scss';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul>
        <li>
          <NavLink to="/admin/livros" className="admin-nav-item">
            <p>Livros</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/clientes" className="admin-nav-item">
            <p>Clientes</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/bandeiras" className="admin-nav-item">
            <p>Bandeiras de Cartão</p>
          </NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
