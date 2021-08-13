<template>
  <div id="aboutDiv">
    <h1>THE GCPT TEAM!</h1>
    <div id="studentDiv">
      <div id="student" class="one">
        <img id="studentImage" src="../images/Fessler,_Tracy_CLE_17.jpg" alt="Tracey Fessler"> 
        <h2 id="studentName">Tracey Fessler</h2>
        <p>Tracy’s quiet nature is a façade; a kindness to the rest of us so we are not instantly blown away by his infectious laugh and wonderful wit. 
          A brilliant builder at heart, he has a knack for encouraging cooperation and his sincerity could humble giants. 
          Tracy is searching for a company to scoop him up and help kick off his illustrious development career. </p>

      </div>
      <div id="student">
          <img id="studentImage" src="../images/Hannah.jpg" alt="Hannah Kohr">
           <h2 id="studentName">Hannah Kohr</h2> 
           <p>Hannah really, really likes people. She brings grandma vibes to the tech world by providing lots of tea, snacks and plants to the Zoom meeting.
              She fosters conversation and team cohesion, and lives in constant, yet content, denial of being labeled bubbly.
               Eager to begin her new journey after Tech Elevator, she has accepted a position at Bravo Wellness as a Product Owner.</p>         
      </div>
      <div id="student">
          <img id="studentImage" src="../images/Will.jpg" alt="Will Summy">
        <h2 id="studentName">Will Summy</h2> 
        <p>Will, a rising star of the tech world, is a mastermind programming architect. The brains of the operation, he orchestrates flow and design with a constant goofy grin and deliriously good sense of humor. 
          A natural artist and analytical thinker, Will will bring any team he joins immense joy, interesting tidbits of obscure information, and a slew of impressive development skills just waiting to blossom.</p>         
      </div>
      <div id="student"> 
          <img id="studentImage" src="../images/Wes W.jpg" alt="Wes Woods">
        <h2 id="studentName">WES WOODS</h2> 
        <p>Wes, wizard of CSS and all things audio, is an all-star coding machine. A man of extraordinary creativity and front-end development prowess, he also loves a good taco and snuggly dogs.
           Wes is still on the market for a job so if you’re in need of a creative team player, he’s waiting to hear from you.</p>        
      </div>
    </div>
    <div id="nonStudent">
      <div id="student" class="one">
        <h1>Product Owner</h1>
        <img id="studentImage" src="../images/Joe.jpg" alt="Joe R"> 
        <h2 id="studentName">Joe Righetti</h2>
        <p>Joe is the most product-oriented product manager that ever managed. A true gem of a leader, 
          he believes strongly in giving his team full creative license - as long as it includes copious amounts of orange - 
          and maintaining a super calm workflow. A current Academic Fellow, Joe is excited for what his future after Tech Elevator might look like. </p>

      </div>
      <div id="student" class="one">
        <h1>Scrum Master</h1>
        <img id="studentImage" src="../images/Beth.jpg" alt="Beth C"> 
        <h2 id="studentName">Beth Campbell</h2>
        <p>Beth, with her towering personality, is the brawn of the team. Her magnetism is impossible to resist, so do not even try to fight it. </p>

      </div>

    
  </div>
</div>
</template>

<script>


</script>

<style>
#aboutDiv {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

#studentDiv {
  display: flex;
  flex-direction: row;
}

#student{
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 5px solid #FF7D00;
    border-radius: 25px;
    padding: 10px;
    margin: 20px;
    height: 50%;
    width: 50%;
   
}

#studentImage {
    width: 25%;
    height: 25%;
}

#nonStudent {
  display: flex;
  flex-direction: row;
}

.one {
  ;  
}


</style>