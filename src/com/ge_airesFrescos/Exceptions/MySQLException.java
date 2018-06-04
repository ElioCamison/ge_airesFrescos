package com.ge_airesFrescos.Exceptions;

import java.sql.SQLException;

public class MySQLException extends SQLException {

    public MySQLException(String reason) {
        super(reason);
    }

    public MySQLException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public MySQLException(Throwable cause) {
        super(cause);
    }


}
