import ActionButtons from "core/components/ActionButtons";
import { Button, Table } from "react-bootstrap";
import "./styles.scss";

const Documentos = () => {
  return (
    <div className="container table-container">
      <Table className="bg-white">
        <thead>
          <tr>
            <th>Código Documento</th>
            <th>Tipo Documento</th>
            <th>Validade Documento</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>000.000.000-00</td>
            <td>CPF</td>
            <td>30/08/2021</td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
          <tr>
            <td>00.000.000-0</td>
            <td>RG</td>
            <td>30/08/2021</td>
            <td colSpan={2}>
              <ActionButtons />
            </td>
          </tr>
        </tbody>
      </Table>

      <div className="button-add-item">
        <Button>Adicionar Documento</Button>
      </div>
    </div>
  );
};

export default Documentos;
