package net.genin.dojo.excep;

import javax.naming.NamingException;

/**
 */
public class MyService {

    public  String run() throws MyBusinessException {
        try {
            final String data = Datas.get();
            if (data != null) {
                return dowork(data);
            } else
                throw new Exception();

        } catch (NamingException e) {
            throw new MyBusinessException("Fatal error !!!");
        } catch (Exception e) {
            throw new MyBusinessException("Fatal error !!!");
        }

    }

    private String dowork(String data) {
        final Integer integer = Integer.valueOf(data);
        return "" + ((integer + 42) - integer);
    }

}
