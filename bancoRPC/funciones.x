struct operaciones{
    double saldo;   
    double cant;    
    int op;
     
};

program SERVIDOR_BANCARIO{
    version VERSION_BANCO {
        double banco(operaciones) = 1;
    } = 1;
} = 0x20000001;
