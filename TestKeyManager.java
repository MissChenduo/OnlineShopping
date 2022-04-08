/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shoppinggui;

/**
 * This Test key manager is for testing purpose
 * @author Chenduo Ouyang 19091093
 */
public class TestKeyManager implements IKeyManager {

    private static Integer id = 1 ;
    @Override
    public int getNextId() {
        return id++ ;
    }

}
