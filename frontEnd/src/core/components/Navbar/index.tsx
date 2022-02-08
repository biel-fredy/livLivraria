import './styles.scss';
import 'bootstrap/js/src/collapse.js';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-xl navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <a href="link" className="nav-logo-text">
          <h4>Liv Livraria</h4>
        </a>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#liv-livraria-navbar"
          aria-controls="liv-livraria-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="liv-livraria-navbar">
          <ul className="navbar-nav offset-md-1 main-menu">
            <li>
              <a href="link" className="nav-link active">
                Home
              </a>
            </li>
            <li className="nav-item dropdown">
              <a
                href="link"
                className="nav-link dropdown-toggle"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
                id="navbarDropdownMenuLink"
              >
                Meu Perfil
              </a>
              <ul
                className="dropdown-menu"
                aria-labelledby="navbarDropdownMenuLink"
              >
                <li>
                  <a className="dropdown-item" href="link">
                    Action
                  </a>
                </li>
                <li>
                  <a className="dropdown-item" href="link">
                    Another action
                  </a>
                </li>
                <li>
                  <a className="dropdown-item" href="link">
                    Something else here
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="link" className="nav-link teste">
                Notificações
              </a>
            </li>
            <li>
              <a href="link" className="nav-link">
                Meu Carrinho
              </a>
            </li>
            <li>
              <a href="link" className="nav-link">
                Meus Pedidos
              </a>
            </li>
            <li>
              <a href="link" className="nav-link">
                Sair
              </a>
            </li>
            <li>
              <a href="link" className="nav-link">
                Cadastre-se
              </a>
            </li>
            <li>
              <a href="link" className="nav-link disabled">
                ADMIN
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
