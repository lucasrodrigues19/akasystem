 --Lucas Rodirgues - 01/10/2021 Criando estrutura para versão 1 de aka system   
 
    create table public.tbcategory (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        primary key (id)
    );
 
    
    create table public.tbfile (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        filetype varchar(80) not null,
        productid varchar(255),
        source oid not null,
        primary key (id)
    );
 
    
    create table public.tborder (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        payamentid varchar(255),
        userid varchar(255),
        primary key (id)
    );
 
    
    create table public.tborderevolution (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        orderstatus varchar(80) not null,
        orderid varchar(255),
        primary key (id)
    );
 
    
    create table public.tborderitem (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        quantity numeric (1) default 0 not null,
        orderid varchar(255) not null,
        productid varchar(255) not null,
        primary key (orderid, productid)
    );
 
    
    create table public.tbpayament (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        primary key (id)
    );
 
    
    create table public.tbprivilege (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        userid varchar(255) not null,
        rolesid varchar(255) not null,
        primary key (rolesid, userid)
    );
 
    
    create table public.tbproduct (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        primary key (id)
    );
 
    
    create table public.tbproductsale (
       id varchar(255) not null,
        userid varchar(255) not null,
        primary key (id)
    );
 
    
    create table public.tbproductsold (
       id varchar(255) not null,
        primary key (id)
    );
 
    
    create table public.tbproductxcategory (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        categoryid varchar(255) not null,
        productid varchar(255) not null,
        primary key (categoryid, productid)
    );
 
    
    create table public.tbroles (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        primary key (id)
    );
 
    
    create table public.tbsales (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        userid varchar(255) not null,
        primary key (id)
    );
 
    
    create table public.tbsalesevolution (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        salesid varchar(255) not null,
        primary key (id)
    );
 
    
    create table public.tbsalesitem (
       dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        price numeric(10,2) default 0.0 not null,
        quantity numeric (1) default 0 not null,
        salesid varchar(255) not null,
        productsaleid varchar(255) not null,
        primary key (productsaleid, salesid)
    );
 
    
    create table public.tbuser (
       id varchar(255) not null,
        dtinsert timestamp not null,
        dtupdate timestamp not null,
        idinsert varchar(255) not null,
        idupdate varchar(255) not null,
        name varchar(255) not null,
        statusactive numeric(1) not null,
        email varchar(255) not null,
        password varchar(25) not null,
        phone varchar(14) not null,
        primary key (id)
    );
 
    
    create table public.tbuserpejorative (
       cnpj varchar(14) not null,
        id varchar(255) not null,
        primary key (id)
    );
 
    
    create table public.tbuserphysical (
       cpf varchar(11) not null,
        id varchar(255) not null,
        primary key (id)
    );
 
    
    alter table public.tbuser 
       drop constraint uk_emailxphone;
 
    
    alter table public.tbuser 
       add constraint uk_emailxphone unique (email, phone);
 
    
    alter table public.tborder 
       add constraint fk_orderxpayament01 
       foreign key (payamentid) 
       references public.tbpayament;
 
    
    alter table public.tborder 
       add constraint fk_orderxuser01 
       foreign key (userid) 
       references public.tbuserphysical;
 
    
    alter table public.tborderevolution 
       add constraint fk_orderxorderevolution 
       foreign key (orderid) 
       references public.tborder;
 
    
    alter table public.tborderitem 
       add constraint fk_orderitemxorder 
       foreign key (orderid) 
       references public.tborder;
 
    
    alter table public.tborderitem 
       add constraint fk_orderitemxproductsold 
       foreign key (productid) 
       references public.tbproductsold;
 
    
    alter table public.tbprivilege 
       add constraint fk_privilegexuser 
       foreign key (userid) 
       references public.tbuser;
 
    
    alter table public.tbprivilege 
       add constraint fk_privilegexroles 
       foreign key (rolesid) 
       references public.tbroles;
 
    
    alter table public.tbproductsale 
       add constraint fk_userpjxproductsale 
       foreign key (userid) 
       references public.tbuserpejorative;
 
    
    alter table public.tbproductsale 
       add constraint fk_productsalexproduct 
       foreign key (id) 
       references public.tbproduct;
 
    
    alter table public.tbproductsold 
       add constraint fk_productsoldxproduct 
       foreign key (id) 
       references public.tbproduct;
 
    
    alter table public.tbproductxcategory 
       add constraint fk_productcategoryxcategory 
       foreign key (categoryid) 
       references public.tbcategory;
 
    
    alter table public.tbproductxcategory 
       add constraint fk_productcategoryxproduct 
       foreign key (productid) 
       references public.tbproduct;
 
    
    alter table public.tbsales 
       add constraint fk_userpjxsales 
       foreign key (userid) 
       references public.tbuserpejorative;
 
    
    alter table public.tbsalesevolution 
       add constraint fk_salesxsalesevolution 
       foreign key (salesid) 
       references public.tbsales;
 
    
    alter table public.tbsalesitem 
       add constraint fk_saleitemxsales 
       foreign key (salesid) 
       references public.tbsales;
 
    
    alter table public.tbsalesitem 
       add constraint fk_saleitemxproductsale 
       foreign key (productsaleid) 
       references public.tbproductsale;
 
    
    alter table public.tbuserpejorative 
       add constraint fk_userpejorativexuser
       foreign key (id) 
       references public.tbuser;
 
    
    alter table public.tbuserphysical 
       add constraint fk_userphysicalxuser
       foreign key (id) 
       references public.tbuser;