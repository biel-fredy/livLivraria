import ActionButtons from "core/components/ActionButtons";
import { Button, Table } from "react-bootstrap";
import "./styles.scss";

const Enderecos = () => {
  return (
    <div className="container table-container border-radius-20">
      <Table className="bg-white">
        <thead>
          <tr>
            <th>Endereço Principal</th>
            <th>Apelido Endereço</th>
            <th>Data de cadastro</th>
            <th>Resumo</th>
            <th colSpan={2}>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Sim</td>
            <td>Minha casa</td>
            <td>19/02/2021</td>
            <td>
              Avenida Bento do Sacramento 300, Vila Lavinia, Mogi das Cruzes -
              SP
            </td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
          <tr>
            <td>Não</td>
            <td>Minha casa</td>
            <td>19/02/2021</td>
            <td>
              Avenida Bento do Sacramento 300, Vila Lavinia, Mogi das Cruzes -
              SP
            </td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
        </tbody>
      </Table>

      <div className="button-add-item">
        <Button>Adicionar Endereço</Button>
      </div>
    </div>
  );
};

export default Enderecos;
