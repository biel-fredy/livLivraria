import {
  Navbar,
  Nav,
  Button,
  NavDropdown,
  FormControl,
  Form,
  Container,
} from 'react-bootstrap';
import './styles.scss';

const Header = () => {
  return (
    <Navbar bg="primary" variant="dark" expand="xl" className="main-navbar">
      <Container>
        <Navbar.Brand href="/">Liv Livraria</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <NavDropdown title="Meu Perfil" id="basic-nav-dropdown">
              <NavDropdown.Item href="/enderecos">
                Gerenciar Endereços
              </NavDropdown.Item>
              <NavDropdown.Item href="/gerenciar/documentos">
                Gerenciar Documentos
              </NavDropdown.Item>
              <NavDropdown.Item href="/gerenciar/cartoes">
                Gerenciar Cartões
              </NavDropdown.Item>
              <NavDropdown.Item href="/alterar/cliente/:idCliente">
                Alterar Dados
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/alterar/cliente/senha/:idCliente">
                Alterar Senha
              </NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Notificações" id="basic-nav-dropdown">
              <NavDropdown.Item href="/trocas/pedido1234">
                Troca autorizada: Pedido 1234
              </NavDropdown.Item>
              <NavDropdown.Item href="/trocas/pedido4321">
                Troca não autorizada: Pedido 4321
              </NavDropdown.Item>
            </NavDropdown>

            <Nav.Link href="/carrinho">Meu Carrinho</Nav.Link>

            <Nav.Link href="/pedidos">Meus Pedidos</Nav.Link>

            <Nav.Link href="/sair">Sair</Nav.Link>

            <Nav.Link href="/cadastrar/cliente">Cadastre-se</Nav.Link>

            <Nav.Link href="/admin">Admin</Nav.Link>
          </Nav>
          <Form className="d-flex">
            <FormControl
              type="search"
              placeholder="Buscar Livro"
              className="mr-2"
              aria-label="Buscar Livro"
            />
            <Button variant="outline-success">Buscar</Button>
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
