/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    x=''+x
    arr = x.split('')
    if(x[0]==='-'){
        arr.splice(0,1)
        value= '-'+arr.reverse().join('')
        if(value<-2147483648)
            return 0
      return value
    }else{
        value=arr.reverse().join('')
        if(value>2147483647)
            return 0
        return value
    }
        
};