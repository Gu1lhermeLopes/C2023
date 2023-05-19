ºclass Frac{
    Integer numerador,denominador;

    Frac(Integer n,Integer d){
        numerador=n;
        denominador=d;
    }

    Frac invert(){
        if (numerador < 0):
            return new Frac(-denominador,-numerador);
        return new Frac(denominador,numerador);

    }
    Frac sum(Frac other){
        Frac res = new Frac(numerador,denominador);
        res.numerador*=other.numerador;
        other.numerador=denominador;
        res.denominador*=other.denominador;
        res.numerador+=other.numerador;
        return res;
    }
    Frac sub(Frac other){
        Frac res = new Frac(numerador,denominador);
        res.numerador*=other.numerador;
        other.numerador=denominador;
        res.denominador*=other.denominador;
        res.numerador-=other.numerador;
        return res;
    }

    Frac mul(Frac other){
        Frac res = (numerador*other.numerador,denominador*=other.denominador);
        return res;
    }

    Frac div(Frac other){
        return mul(other.invert());
    }

    Frac power(Frac exp){
        Frac orig=null;
        try {
            orig = (Frac)this.clone();
            assert(exp.denominador == 1);
        } catch (Exception e) {
        }

        for(;exp.numerador>1; exp.numerador--){
            mul(orig);
        }
        return this;
    }

    Integer lcm(Integer a, Integer b){
        if (a<b) return lcm(b,a);
        
        for(int i=1;;i++){
            if(a *i % b == 0) return a*i;
        }
    }

    Frac reduce(){
        Integer gcd;
        if (numerador == 0) 
            return this;
        gcd = numerador * denominador;
        gcd /= lcm(numerador,denominador);

        return new Frac(numerador/gcd,denominador/gcd);
    }
    Frac minus(){
        numerador*=-1;
        return this;
    }

    void
}
