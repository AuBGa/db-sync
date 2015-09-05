/**
 * @author Michał Fraś
 */
package com.frasiek.dss.connection;

/**
 *
 * 
 */
public class Manager {

    public static Connection getConnection(String type, String host, String port, String username, String password) throws ConnectionException {
        Connection c = null;
        Integer portInt = 0;
        try {
            if (port.equals("") == false) {
                portInt = new Integer(port);
            }
        } catch (NumberFormatException e) {
            throw new ConnectionException("Błędny numer portu.");
        }
        switch (type) {
            case "Bezpośrednie połączenie":
                if (port.equals("")) {
                    c = new Direct(host, username, password);
                } else {
                    c = new Direct(host, username, password, portInt);
                }
                break;
            case "HTTP PHP Proxy":
                c = new PhpProxy(host, username, password, portInt);
                break;

            default:
                throw new ConnectionException("Nieznany typ połączenia.");
        }
        return c;
    }

}
