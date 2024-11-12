
package interface03;

/**
 *
 * @author Jorge
 */
public class CalculadoraBasica implements CalculosAritmeticosDosEnteros, CalculosAritmeticosDosDobles, CalculosAritmeticosVariosEnteros, CalculosAritmeticosVariosDobles {
    // Implementación de métodos para DosEnteros
    @Override
    public int suma (int n1, int n2){
        return n1+n2;
    }
    
    @Override
    public int resta (int n1, int n2){
        return n1-n2;
    }
    
    @Override
    public int multiplica (int n1, int n2){
        return n1*n2;
    }
    
    @Override
    public int divide (int n1, int n2){
        return n1/n2;
    }
    //implementación para métodos dos dobles
    @Override
    public double suma (double n1, double n2){
        return n1+n2;
    }
    
    @Override
    public double resta (double n1, double n2){
        return n1-n2;
    }
    
    @Override
    public double multiplica (double n1, double n2){
        return n1*n2;
    }
    @Override
    public double divide (double n1, double n2){
        return n1/n2;
    }
    //implementar metodos de VariosEnteros
    @Override
    public int suma (int[] nums){
        int suma = 0;
        for (int num : nums){
            suma += num;
        }
        return suma;
    }
    @Override
    public int resta (int[] nums){
        int resta = nums[0];
        for (int i = 1; i < nums.length; i++){
            resta-= nums[i];
        }
        return resta;       
    }
    
    @Override
    public int multiplica (int[] nums){
        int pro = 1;
        for (int num : nums){
            pro*= num;
        }
        return pro;
    }
    
    @Override
    public int divide (int[] nums){
        int res = nums [0];
        for (int i=1; i < nums.length; i++){
            res/= nums[i];
        }
        return res;
    }
    //implementar metodos de varios dobles
    @Override
    public double suma (double[] nums){
        double suma = 0.0;
        for (double num : nums){
            suma +=num;
        }
        return suma;
    }    
    @Override
    public double resta (double[] nums){
        double resta = nums[0];
        for (int i = 1; i < nums.length; i++){
            resta-=nums[i];
        }
        return resta;        
    }    
    @Override
    public double multiplica (double[] nums){
        double multi = 1.0;
        for (double num : nums){
            multi*=num;
        }
        return multi;         
    }
    @Override
    public double divide (double[] nums){
        double div = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != 0){
            div /= nums[i];
            }
        }
        return div;
    }
    
   
}
