package common;

import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.PropertyPermission;

public class MinimalPolicy extends Policy {
	private static PermissionCollection perms;

    public MinimalPolicy() {
        super();
        if (perms == null) {
            perms = new MyPermissionCollection();
            addPermissions();
        }
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return perms;
    }

    private void addPermissions() {
        SocketPermission socketPermission = new SocketPermission("*:1024-", "connect, resolve");
        PropertyPermission propertyPermission = new PropertyPermission("*", "read, write");
        FilePermission filePermission = new FilePermission("<<ALL FILES>>", "read");

        perms.add(socketPermission);
        perms.add(propertyPermission);
        perms.add(filePermission);
    }
}

class MyPermissionCollection extends PermissionCollection {

    private static final long serialVersionUID = 614300921365729272L;

    ArrayList<Permission> perms = new ArrayList<Permission>();

    public void add(Permission p) {
        perms.add(p);
    }

    public boolean implies(Permission p) {
        for (Iterator<Permission> i = perms.iterator(); i.hasNext();) {
            if (((Permission) i.next()).implies(p)) {
                return true;
            }
        }
        return false;
    }

    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }

    public boolean isReadOnly() {
        return false;
    }

}