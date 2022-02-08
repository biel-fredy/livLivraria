import ActionButtons from "core/components/ActionButtons";
import { Button, Table } from "react-bootstrap";
import "./styles.scss";

const Cartoes = () => {
  return (
    <div className="container table-container">
      <Table className="bg-white">
        <thead>
          <tr>
            <th>Cartão Principal</th>
            <th>Número Cartão</th>
            <th>Data de Cadastro</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Sim</td>
            <td>XXXX-XXXX-XXXX-3090</td>
            <td>30/01/2021</td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
          <tr>
            <td>Não</td>
            <td>XXXX-XXXX-XXXX-6690</td>
            <td>30/01/2021</td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
        </tbody>
      </Table>

      <div className="button-add-item">
        <Button>Adicionar Cartão</Button>
      </div>
    </div>
  );
};

export default Cartoes;
