<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> index </title>
</head>

<body>
<div id='main' class='section dark'>
    <div class='step'>choose an image file</div>
    <img id='preview' class='preview hide'/>
    <div class='sectionbody'>
        <input type='file' id='file'/>
    </div>
</div>
<div id='choose' class='section dark hide'>
    <div class='step'>What do you want to do?,
        <div id="aa"></div>
        >>>>
        <div id="bb"></div>
    </div>
    <div class='sectionbody'>
        <div class='left'>
                <textarea id='message' class='message' style="height:200px;width:600px;"
                          placeholder='Type hidden text'
                          onchange="document.getElementById('bb').innerHTML=this.value.length"></textarea>
            <br/>
            <button id='encode' class='submit'>Hide text</button>
            <button id='decode' class='submit'>Reveal text</button>
            <label><input type="checkbox" id="debug"/>debug mode</label>
            <hr/>
            hidden file: <input type='file' id='file2'/><br/>
            <button id='encode2' class='submit'>Hide file</button>
            <button id='decode2' class='submit'>Reveal file</button>
            <button id='decode3' class='submit'>Reveal file2</button>
            <div id="files"></div>
        </div>
    </div>
</div>
<canvas id='canvas' style="display:none;"></canvas>
<img id='output'/>
<script type="text/javascript" src="resources/js/imagemask.js"></script>
<script type="text/javascript">
    var mask = new ImageMask({debug: false});

    window.onload = function () {
        // add action to the file input
        var input = document.getElementById('file');
        input.addEventListener('change', importImage);

        // add action to the encode button
        var encodeButton = document.getElementById('encode');
        encodeButton.addEventListener('click', encode);

        // add action to the decode button
        var decodeButton = document.getElementById('decode');
        decodeButton.addEventListener('click', decode);

        // add action to the encode button
        var encodeButton2 = document.getElementById('encode2');
        encodeButton2.addEventListener('click', encode2);

        // add action to the decode button
        var decodeButton2 = document.getElementById('decode2');
        decodeButton2.addEventListener('click', decode2);

        var decodeButton3 = document.getElementById('decode3');
        decodeButton3.addEventListener('click', decode3);
    };

    // put image in the canvas and display it
    var importImage = function (e) {
        var reader = new FileReader();

        reader.onload = function (event) {
            // set the preview
            document.getElementById('preview').style.display = 'block';
            document.getElementById('preview').src = event.target.result;

            // wipe all the fields clean
            document.getElementById('message').value = '';
            document.getElementById('output').src = '';

            // read the data into the canvas element
            var img = new Image();
            img.onload = function () {
                var canvas = document.getElementById('canvas');
                var ctx = canvas.getContext('2d');
                ctx.canvas.width = img.width;
                ctx.canvas.height = img.height;
                ctx.drawImage(img, 0, 0);

                var count = mask.maxTextLength(canvas);
                document.getElementById('aa').innerHTML = 'the hidden text max length: ' + count + ' || the hidden file max size: ' + (mask.maxFileSize(canvas) / 1024).toFixed(2) + 'KB';
                //decode();
            };
            img.src = event.target.result;
        };

        reader.readAsDataURL(e.target.files[0]);
    };

    // encode the image and save it
    var encode = function () {
        var message = document.getElementById('message').value;
        var output = document.getElementById('output');
        var canvas = document.getElementById('canvas');
        var debug = document.getElementById('debug');
        var preview = document.getElementById('preview');
        var ctx = canvas.getContext('2d');
        ctx.drawImage(preview, 0, 0, preview.width, preview.height);

        mask.opts.debug = debug.checked;
        mask.hideText(canvas, message);
        output.src = canvas.toDataURL();
    };
    // decode the image and display the contents if there is anything
    var decode = function () {
        // decode the message with the supplied password
        var canvas = document.getElementById('canvas');
        var message = mask.revealText(canvas);

        document.getElementById('message').value = message;
    };
    // encode the image and save it
    var encode2 = function () {
        var output = document.getElementById('output');
        var canvas = document.getElementById('canvas');
        var input = document.getElementById('file2');
        var debug = document.getElementById('debug');
        var preview = document.getElementById('preview');
        var ctx = canvas.getContext('2d');
        ctx.drawImage(preview, 0, 0, preview.width, preview.height);

        mask.opts.debug = debug.checked;

        mask.hideFile(canvas, input.files[0], function (result) {
            if (result.success) {
                output.src = canvas.toDataURL();
            } else {
                alert(result.message);
            }
        });

    };

    function createFileBlob(data, name) {
        const file = new window.Blob([data], {type: "application/octet-binary"})
        const fileUrl = window.URL.createObjectURL(file)

        const files = document.getElementById('files')
        const link = document.createElement('a')
        link.setAttribute('href', fileUrl)
        link.setAttribute('download', name)

        link.innerText = name + ' - Size: ' + file.size
        files.appendChild(link);
    }

    // decode the image and display the file if there is anything
    var decode2 = function () {
        // decode the message with the supplied password
        var canvas = document.getElementById('canvas');
        var file = mask.revealFile(canvas);
        createFileBlob(file.data, file.name);
    };

    var decode3 = function () {
        // decode the message with the supplied password
        var canvas = document.getElementById('canvas');
        var preview = document.getElementById('preview');
        var ctx = canvas.getContext('2d');
        ctx.drawImage(preview, 0, 0, preview.width, preview.height);
        var fileReader = new FileReader();
        // var self = this;
        // fileReader.addEventListener("loadend", function(event) {
        // var data = new Uint8Array(fileReader.readAsArrayBuffer(file).target.result);
        // var fileName = "11111111111111";

        // var ctx = canvas.getContext('2d');
        var pixelCount = ctx.canvas.width * ctx.canvas.height;

        var imgData = ctx.getImageData(0, 0, ctx.canvas.width, ctx.canvas.height);
        // var colorMask = new ImageColorMask(imgData.data, self.opts);
        // colorMask.writeNumber(fileName.length, 8);
        // for(var i=0; i<fileName.length; i++){
        //     colorMask.writeNumber(fileName.charCodeAt(i), self.opts.charSize);
        // }

        // colorMask.writeNumber(data.length, self.opts.lengthSize);
        // for(var i=0; i<data.length; i++){
        //     colorMask.writeNumber(data[i], 8);
        // }

        ctx.putImageData(imgData, 0, 0);


        // });


        // mask.opts.debug = debug.checked;

        // var a = document.getElementById("preview").src;
        // document.getElementById("output").src=a;

        var file = mask.revealFile(canvas);
        createFileBlob(file.data, file.name);
    };

</script>
</body>
</html>