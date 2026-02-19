function Tabele({vetor, selecionar}) {
    return(
        <table className='table'>
            <thead>
             <tr>
                 <th>id</th>
                <th>Name</th>
                <th>marca</th>
                <th>Selecionar</th>
            </tr>
        </thead>
        <tbody>
        {vetor.map((obj, indice) => (
          <tr key={indice}>
            <td>{indice + 1}</td>
            <td>{obj.name}</td>
            <td>{obj.description}</td>
            <td><button onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</button></td>
          </tr>
        ))}
            </tbody>
        </table>
    )
}

export default Tabele;