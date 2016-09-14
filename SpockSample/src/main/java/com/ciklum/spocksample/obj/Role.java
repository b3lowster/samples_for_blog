package com.ciklum.spocksample.obj;

import java.util.Map;

/**
 * @author tsv@ciklum.com
 */
public class Role {

    private String roleName;
    private Map<String, String> permissions;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Map<String, String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, String> permissions) {
        this.permissions = permissions;
    }
}
