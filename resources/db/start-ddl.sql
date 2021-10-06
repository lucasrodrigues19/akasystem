 --Lucas Rodirgues - 01/10/2021 Criando estrutura para versão 1 de aka system   

    
    create table _create.tbcategory (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        primary key (id)
    );

    
    create table _create.tbfile (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        filetype varchar(80) not null,
        productid varchar(255),
        source oid not null,
        primary key (id)
    );
 
    
    create table _create.tborder (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        payamentid varchar(255),
        userid varchar(255),
        primary key (id)
    );
 
    
    create table _create.tborderevolution (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        orderstatus varchar(80) not null,
        orderid varchar(255),
        primary key (id)
    );
 
    
    create table _create.tborderitem (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        quantity numeric (1) default 0 not null,
        orderid varchar(255) not null,
        productid varchar(255) not null,
        primary key (orderid, productid)
    );
 
    
    create table _create.tbpayament (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        primary key (id)
    );
 
    
    create table _create.tbprivilege (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        userid varchar(255) not null,
        rolesid varchar(255) not null,
        primary key (rolesid, userid)
    );
 
    
    create table _create.tbproduct (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        primary key (id)
    );
 
    
    create table _create.tbproductsale (
       id varchar(255) not null,
        userid varchar(255) not null,
        primary key (id)
    );
 
    
    create table _create.tbproductsold (
       id varchar(255) not null,
        primary key (id)
    );
 
    
    create table _create.tbproductxcategory (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        categoryid varchar(255) not null,
        productid varchar(255) not null,
        primary key (categoryid, productid)
    );
 
    
    create table _create.tbroles (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        primary key (id)
    );
 
    
    create table _create.tbsales (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        userid varchar(255) not null,
        primary key (id)
    );
 
    
    create table _create.tbsalesevolution (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        salesid varchar(255) not null,
        primary key (id)
    );
 
    
    create table _create.tbsalesitem (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        quantity numeric (1) default 0 not null,
        salesid varchar(255) not null,
        productsaleid varchar(255) not null,
        primary key (productsaleid, salesid)
    );
 
    
    create table _create.tbuser (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        _name varchar(255) not null,
        _status numeric(1) not null,
        email varchar(255) not null,
        _password varchar(25) not null,
        phone varchar(14) not null,
        primary key (id)
    );
 
    
    create table _create.tbuserpejorative (
       cnpj varchar(14) not null,
        id varchar(255) not null,
        primary key (id)
    );
 
    
    create table _create.tbuserphysical (
       cpf varchar(11) not null,
        id varchar(255) not null,
        primary key (id)
    );
 
    
    alter table _create.tbuser 
       drop constraint if exists uk_emailxphone;
 
    
    alter table _create.tbuser 
       add constraint uk_emailxphone unique (email, phone);
 
    
    alter table _create.tborder 
       add constraint fk_orderxpayament01 
       foreign key (payamentid) 
       references _create.tbpayament;
 
    
    alter table _create.tborder 
       add constraint fk_orderxuser01 
       foreign key (userid) 
       references _create.tbuserphysical;
 
    
    alter table _create.tborderevolution 
       add constraint fk_orderxorderevolution 
       foreign key (orderid) 
       references _create.tborder;
 
    
    alter table _create.tborderitem 
       add constraint fk_orderitemxorder 
       foreign key (orderid) 
       references _create.tborder;
 
    
    alter table _create.tborderitem 
       add constraint fk_orderitemxproductsold 
       foreign key (productid) 
       references _create.tbproductsold;
 
    
    alter table _create.tbprivilege 
       add constraint fk_privilegexuser 
       foreign key (userid) 
       references _create.tbuser;
 
    
    alter table _create.tbprivilege 
       add constraint fk_privilegexroles 
       foreign key (rolesid) 
       references _create.tbroles;
 
    
    alter table _create.tbproductsale 
       add constraint fk_userpjxproductsale 
       foreign key (userid) 
       references _create.tbuserpejorative;
 
    
    alter table _create.tbproductsale 
       add constraint fk_productxproductsale 
       foreign key (id) 
       references _create.tbproduct;
 
    
    alter table _create.tbproductsold 
       add constraint fk_productxproductsold 
       foreign key (id) 
       references _create.tbproduct;
 
    
    alter table _create.tbproductxcategory 
       add constraint fk_productcategoryxcategory 
       foreign key (categoryid) 
       references _create.tbcategory;
 
    
    alter table _create.tbproductxcategory 
       add constraint fk_productcategoryxproduct 
       foreign key (productid) 
       references _create.tbproduct;
 
    
    alter table _create.tbsales 
       add constraint fk_userpjxsales 
       foreign key (userid) 
       references _create.tbuserpejorative;
 
    
    alter table _create.tbsalesevolution 
       add constraint fk_salesxsalesevolution 
       foreign key (salesid) 
       references _create.tbsales;
 
    
    alter table _create.tbsalesitem 
       add constraint fk_saleitemxsales 
       foreign key (salesid) 
       references _create.tbsales;
 
    
    alter table _create.tbsalesitem 
       add constraint fk_saleitemxproductsale 
       foreign key (productsaleid) 
       references _create.tbproductsale;
 
    
    alter table _create.tbuserpejorative 
       add constraint fk_userxuserpejorative 
       foreign key (id) 
       references _create.tbuser;
 
    
    alter table _create.tbuserphysical 
       add constraint fk_userxuserphysical
       foreign key (id) 
       references _create.tbuser;