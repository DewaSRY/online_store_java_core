package org.sdewa;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import org.sdewa.AppContext.Context;


import org.sdewa.entities.Product;
import org.sdewa.entities.impl.ProductDto;
import org.sdewa.menues.*;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.ProductManagement;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.UserManagementServices;
import org.sdewa.services.impl.ProductManagementService;
import org.sdewa.services.impl.AuthManagementServices;

public class Main {


    public static void main(String[] args) {
        var context = Context.getInstance();
        context.putServices(new OrderManagementService(new ArrayList<>()));
        context.putServices(new UserManagementServices(new ArrayList<>()));
        context.putServices(new ProductManagementService(getInitProduct()));
        context.putServices(new AuthManagementServices());
        context.putMenu(new AuthMenu(
                context,
                context.<AuthManagement>getService(AuthManagementServices.class),
                context.<UserManagement>getService(UserManagementServices.class)));
        context.putMenu(new ChangeEmailMenu(
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new ChangePasswordMenu(
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new CheckoutMenu(
                context.<OrderManagement>getService(OrderManagementService.class),
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new CustomerListMenu(
                context.<UserManagement>getService(UserManagementServices.class)));
        context.putMenu(new MainMenu(context));
        context.putMenu(new MyOrderMenu(
                context.<AuthManagement>getService(AuthManagementServices.class),
                context.<OrderManagement>getService(OrderManagementService.class)));
        context.putMenu(new MyOrderMenu(
                context.<AuthManagement>getService(AuthManagementServices.class),
                context.<OrderManagement>getService(OrderManagementService.class)));
        context.putMenu(new ProductCatalogMenu(
                context.<ProductManagement>getService(ProductManagementService.class),
                context.<OrderManagement>getService(OrderManagementService.class),
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new SettingMenu(
                context,
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new SignInMenu(
                context.<UserManagement>getService(UserManagementServices.class),
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new SignOutMenu(
                context.<AuthManagement>getService(AuthManagementServices.class)));
        context.putMenu(new SignUpMenu(
                context.<UserManagement>getService(UserManagementServices.class)));
        context.runtMenu(MainMenu.class);
    }


    private static List<Product> getInitProduct() {
        return new ArrayList<>(Arrays.asList(
                new ProductDto(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
                new ProductDto(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
                new ProductDto(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
                new ProductDto(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
                new ProductDto(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
                new ProductDto(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
                new ProductDto(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
                new ProductDto(8, "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
                new ProductDto(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
                new ProductDto(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
        ));
    }
}