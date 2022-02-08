import { Form, Button, Card } from 'react-bootstrap';
import '../styles.scss';
import { useForm } from 'react-hook-form';

type FormData = {
  numeroCartao : string;
}

const CadastroCartao = () => {
  const { register, handleSubmit } = useForm<FormData>();

  const onSubmit = (formData : FormData) => {
    console.log(formData);
  };

  return (
    <div className="container cadastro-container">
      <Card className="card-base border-radius-20">
        <Card.Body>
          <Form onSubmit={handleSubmit(onSubmit)}>
            <h2 className="cadastro-title">Informações do cartão</h2>
            <Form.Group controlId="informacaoes-cartao">
              <Form.Label>Número Cartão</Form.Label>
              <Form.Control
                {...register('numeroCartao')}
                className="mb-2"
                id="numeroCartao"
                name="numeroCartao"
                type="text"
                placeholder="Digite o número do cartão"
              />
            </Form.Group>

            <Form.Group controlId="informacaoes-cartao">
              <Form.Label>Nome impresso Cartão</Form.Label>
              <Form.Control
                className="mb-2"
                id=""
                type="text"
                placeholder="Digite o nome impresso no cartão"
              />
            </Form.Group>

            <Form.Group controlId="informacaoes-cartao">
              <Form.Label>Bandeira</Form.Label>
              <Form.Control
                className="mb-2"
                id=""
                type="text"
                placeholder="Digite a bandeira"
              />
            </Form.Group>

            <Form.Group controlId="informacaoes-cartao">
              <Form.Label>Código de Segurança</Form.Label>
              <Form.Control
                className="mb-2"
                id=""
                type="text"
                placeholder="Digite o número do cartão"
              />
            </Form.Group>

            <Button variant="primary" type="submit">
              Salvar alterações
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </div>
  );
};

export default CadastroCartao;
