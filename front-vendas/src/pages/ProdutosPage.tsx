/* eslint-disable @typescript-eslint/no-explicit-any */
import { useEffect, useReducer, useState } from 'react'
import { request, setAuthHeader } from '../helpers/axios_helper';

interface Produto {
    id: number;
    SKU: string;
    produto: string;
    preco_cheio: number;
    preco_descontado: number;
  }

function ProdutosPage() {
    const [produtos, setProdutoes] = useState<Produto[]>([]);
    const [reducerValue, forceUpdate] = useReducer((x) => x + 1, 0);

    useEffect(() => {
    const fetchData = async () => {
        try {
        const response = await request("GET", "/produto", {});
        setProdutoes(response.data);
          console.log(response.data);
        } catch (error: any) {
        if (error.response.status === 401) {
            setAuthHeader(null);
        } else {
            setProdutoes([error.response.code]);
        }
        }
    };

    fetchData();
    }, [reducerValue]);
    return (
    <div>
        <h2>Listagem de Produtos</h2>
      <table className="custom-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>SKU</th>
            <th>produto</th>
            <th>preco_cheio</th>
            <th>preco_descontado</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {produtos.map((produto) => (
            <tr key={produto.id}>
              <td>{produto.id}</td>
              <td>{produto.SKU}</td>
              <td>{produto.produto}</td>
              <td>{produto.preco_cheio}</td>
              <td>{produto.preco_descontado}</td>
              <td>
                {/* <button
                  type="button"
                  className="btn btn-secondary"
                  onClick={() => handleEditButtonClick(produto)}
                >
                  Editar
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => handleDeleteButtonClick(produto)}
                >
                  Remover
                </button> */}
                ações
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button className="btn btn-primary" onClick={forceUpdate}>
        Recarregar
      </button>
    </div>
    )
}

export default ProdutosPage