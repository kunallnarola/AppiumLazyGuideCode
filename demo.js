import { Selector } from 'testcafe'; // first import testcafe selectors
fixture `Getting Started`// declare the fixture
.page `www.google.com`;  // specify the start page

//then create a test and place your code there
test('My first test', async t => {
    await t
        .typeText('input[name="q"]'', 'TestCafe')
        .click('input[value="Google Search"]')
        
});