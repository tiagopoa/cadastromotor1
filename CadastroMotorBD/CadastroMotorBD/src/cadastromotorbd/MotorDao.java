/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastromotorbd;

/**
 *
 * @author 630610194
 */
public interface MotorDao {
    public void inserir(Motor m);
    public void deletar(Motor m);
    public void atualizar(Motor m);
    public List<Motor> listar();
    public Motor buscarPorId(int id);
    
    
}
