import axios, { AxiosRequestConfig } from 'axios';
import { Endereco } from 'core/types/endereco';
import { TipoEndereco } from 'core/types/enums/tipoendereco';
import { BASE_URL } from 'core/utils/requests';
import { useState, useEffect } from 'react';
import { Button } from 'react-bootstrap';
import { useForm } from 'react-hook-form';
import { Link, useParams } from 'react-router-dom';
import { ClienteDTO } from 'core/types/dto/clienteDTO';
import FormEndereco from '../Form';

const ListEndereco = () => {
  return (
    <table className="table">
      <thead>
        <tr>
          <th>CEP</th>
          <th>Logradouro</th>
          <th>Tipo Endereço</th>
          <th colSpan={4}>Ações</th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
  );
};
export default ListEndereco;
