<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>File IO</title>
</head>
<body>
    <h1>File Upload</h1>

    <h4>cos single file</h4>
    <form action="cos/single" method="post" enctype="multipart/form-data">
        <input type="file" name="singlefile">
        <br>
        <input type="tex" name="description">
        <button type="submit">Send</button>
    </form>

    <h4>cos multi file</h4>
    <p>cos.jar로는 multiple 속성을 이용하여 파일 업로드 처리를 할 수 없음</p>
    <form action="cos/multi" method="post" enctype="multipart/form-data">
        <input type="file" name="multifile" multiple>
        <br>
        <input type="text" name="description">
        <button type="submit">Send</button>
    </form>

    <h4>cos many files</h4>
    <p>multiple 속성을 이용하지 않고 여러 개의 input type="file"을 이용하여 다중 업로드 가능</p>
    <form action="cos/many" method="post" enctype="multipart/form-data">
        <input type="file" name="first"><br>
        <input type="file" name="second"><br>
        <input type="file" name="third"><br>
        <input type="text" name="description"><br>
        <button type="submit">Send</button>
    </form>

    <h4>commons file upload</h4>
    <p>commons fileupload 라이브러리를 이용하면 multiple과 여러 input 태그를 사용하는 것 모두 가능</p>
    <form action="commons/single" method="post" enctype="multipart/form-data">
        <input type="file" name="singlefile1" multiple><br>
        <input type="file" name="singlefile2" multiple><br>
        <input type="text" name="description">
        <button type="submit">Send</button>
    </form>

    <h3>transfer to thumbnail</h3>
    <button onclick="loaction.href='transferToThumbnail'">Transfer To Thumbnail Image</button>
</body>
</html>