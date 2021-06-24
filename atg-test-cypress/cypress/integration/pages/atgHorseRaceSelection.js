/// <reference types="cypress" />

    //Actions
    function performHorseSelection(){
        cy.get('[data-test-id="coupon-button-leg-1-start-1"]').click()
            cy.get('[data-test-id="coupon-button-leg-1-start-2"]').click()
            cy.get('[data-test-id="coupon-button-leg-1-start-3"]').click()
            cy.get('[data-test-id="coupon-button-leg-1-start-4"]').click()
            cy.get('[data-test-id="coupon-button-leg-2-start-1"]').click()
            cy.get('[data-test-id="coupon-button-leg-3-start-2"]').click()
            cy.get('[data-test-id="coupon-button-leg-3-start-3"]').click()
            cy.get('[data-test-id="leg-4-toggle-all"]').click()   
    }
    //Exports
    module.exports = {
        performHorseSelection
    } 