import {expect, test} from '@playwright/test';

test('Testa att balance går att nå', async ({page}) => {
    const response = await page.goto('http://localhost:8080/balance');
    expect(response).not.toBeNull();
    expect(response.status()).toBe(200);
});

test('Testa att sidan laddas korrekt', async ({page}) => {
    await page.goto('http://localhost:8080/balance');
    await expect(page.locator('h1')).toHaveText('Saldo');
});

test('Testa att saldo visas korrekt', async ({page}) => {
    await page.goto('http://localhost:8080/balance');

    await expect(page.locator('p'))
        .toHaveText(/Saldo: 0/);
});


