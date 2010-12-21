/**
 *
 */
eval(loadFile("src/main/webapp/factorial.js"));

testCases(test, function test15() {
    assert.that(factorial(15), eq(1307674368000));
}, function test16() {
    assert.that(factorial(16), eq(20922789888000));
});
