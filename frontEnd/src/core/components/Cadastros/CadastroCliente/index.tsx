import { Form, Button, Card, Col } from "react-bootstrap";
import '../styles.scss'

function CadastroCliente() {
  return (
    <div className="container cadastro-container">
      <Card className="card-base border-radius-20">
        <Card.Body>
          <Form>
            <h2 className="cadastro-title">Informações da conta</h2>
            <Form.Group controlId="informacaoes-conta">
              <Form.Label>Nome</Form.Label>
              <Form.Control
                className="mb-2"
                id=""
                type="text"
                placeholder="Digite Nome"
              />
            </Form.Group>

            <Form.Group controlId="cadastro-endereco">
              <h2 className="cadastro-title">Endereço</h2>
              <Form.Label>Logradouro</Form.Label>
              <Form.Control
                className="mb-2"
                id=""
                type="text"
                placeholder="Digite o logradouro deste endereço"
              />
            </Form.Group>
            <Form.Row>
              <Form.Group as={Col} md="3" controlId="">
                <Form.Label>Número</Form.Label>
                <Form.Control type="text" placeholder="Número" required />
              </Form.Group>

              <Form.Group as={Col} md="3" controlId="validationCustom05">
                <Form.Label>CEP</Form.Label>
                <Form.Control type="text" placeholder="CEP" required />
              </Form.Group>

              <Form.Group as={Col} md="6" controlId="validationCustom05">
                <Form.Label>Complemento</Form.Label>
                <Form.Control type="text" placeholder="Complemento" required />
              </Form.Group>
            </Form.Row>

            <Form.Row>
              <Form.Group as={Col} md="6" controlId="">
                <Form.Label>Cidade</Form.Label>
                <Form.Control type="text" placeholder="Cidade" required />
                <Form.Control.Feedback type="invalid">
                  Digite uma cidade válida.
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group as={Col} md="6" controlId="validationCustom04">
                <Form.Label>Estado</Form.Label>
                <Form.Control type="text" placeholder="Estado" required />
                <Form.Control.Feedback type="invalid">
                  Digite um estado válido.
                </Form.Control.Feedback>
              </Form.Group>
            </Form.Row>

            <Form.Group controlId="documento">
              <h2 className="cadastro-title">Documento</h2>
              <Form.Row>
                <Form.Group as={Col} md="4" controlId="validationCustom04">
                  <Form.Label>Código</Form.Label>
                  <Form.Control type="text" placeholder="Código" required />
                </Form.Group>

                <Form.Group as={Col} md="4" controlId="validationCustom04">
                  <Form.Label>Validade</Form.Label>
                  <Form.Control type="text" placeholder="Validade" required />
                </Form.Group>

                <Form.Group as={Col} md="4" controlId="validationCustom04">
                  <Form.Label>Tipo Documento</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Tipo Documento"
                    required
                  />
                </Form.Group>
              </Form.Row>
            </Form.Group>
          </Form>

          <Button variant="primary" type="submit">
            Salvar alterações
          </Button>
        </Card.Body>
      </Card>
    </div>
  );
}

export default CadastroCliente;
