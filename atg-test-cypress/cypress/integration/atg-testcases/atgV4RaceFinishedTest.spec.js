/// <reference types="cypress" />
describe('Verify functional behavior of V4 Race when race is finished.', () => {
    it('Visit to ATG website', () => {
      cy.visit('https://atg.se')
      cy.get('#onetrust-accept-btn-handler').click()
      cy.get('[data-test-id="overlay-side-menu"]').click()
      cy.get('[data-test-id="horse-verticals-menu"]').click()
      cy.get('[data-test-id="quicklinks-calendar-horsebetting"]').click()
      cy.get('[data-test-id="calendar-game-menu-label"]').click()
     
      cy.get('[data-test-id="calendar-previous-day-button"]').click()
      cy.get('[data-test-id="calendar-menu-gameType-V4"]').click()
      cy.get('[data-test-id="button-standard"]').should('exist')
      cy.log("Race is already Compeleted.")
   
    })
})